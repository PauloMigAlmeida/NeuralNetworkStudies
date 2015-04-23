/**
 *   (The MIT License)
 * 
 *   https://github.com/pauloubuntu/NeuralNetworkStudies
 *
 *   Copyright (c) 2015 Paulo Miguel Almeida Rodenas <paulo.ubuntu@gmail.com>
 *
 *   Permission is hereby granted, free of charge, to any person obtaining
 *   a copy of this software and associated documentation files (the
 *   'Software'), to deal in the Software without restriction, including
 *   without limitation the rights to use, copy, modify, merge, publish,
 *   distribute, sublicense, and/or sell copies of the Software, and to
 *   permit persons to whom the Software is furnished to do so, subject to
 *   the following conditions:
 *
 *   The above copyright notice and this permission notice shall be
 *   included in all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND,
 *   EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *   MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 *   IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 *   CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 *   TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 *   SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.pauloubuntu.neuralnetworkstudies.tranning;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.github.pauloubuntu.neuralnetworkstudies.nnet.TrainingSet;

public class BackPropagationLearningAlgorithm {

    private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private TrainingSet trainingSet;

    public BackPropagationLearningAlgorithm(TrainingSet trainingSet) {
        this.trainingSet = trainingSet;
    }

    public void train(double learningRate, long numSteps) {
        logger.log(Level.INFO, String.format("Trainning started with learningRate of: %f", learningRate));
        for (int i = 0, tranningSampleIndex = 0; i < numSteps; i++, tranningSampleIndex++) {

            double[] errorOutputLayer = new double[trainingSet.getNetwork().getOutputLayer().size()];
            double[] errorHiddenLayer = new double[trainingSet.getNetwork().getHiddenLayer().size()];

            // if we run out of sample then we simply iterave it over and over again
            if (tranningSampleIndex == trainingSet.getX().length) {
                tranningSampleIndex = 0;
            }
            double[] tranningSample = trainingSet.getX()[tranningSampleIndex];
            double[] actualOutput = trainingSet.getNetwork().predict(tranningSample, false);
            double[] targetOutput = trainingSet.getY()[tranningSampleIndex];

            // Calculate the output layer error.
            for (int out = 0; out < trainingSet.getNetwork().getOutputLayer().size(); out++) {
                errorOutputLayer[out] = (targetOutput[out] - actualOutput[out]) * sigmoidDerivative(actualOutput[out]);
            }
            
            // Calculate the hidden layer error
            for (int hidden = 0; hidden < trainingSet.getNetwork().getHiddenLayer().size(); hidden++) {
                errorHiddenLayer[hidden] = 0.0;
                for (int out = 0; out < trainingSet.getNetwork().getOutputLayer().size(); out++) {
                    errorHiddenLayer[hidden] = errorOutputLayer[out] * trainingSet.getNetwork().getOutputLayer().getProcessNeurons()[out].getWeightValues()[hidden];
                }
                if(hidden != 0){
                    errorHiddenLayer[hidden] *= sigmoidDerivative(trainingSet.getNetwork().getHiddenLayer().getProcessNeurons()[hidden].getOutputValue());
                }                
            }

            // Update the weights for the output layer
            for (int out = 0; out < trainingSet.getNetwork().getOutputLayer().size(); out++) {
                for (int hidden = 0; hidden < trainingSet.getNetwork().getHiddenLayer().size() + 1; hidden++) {
                    if (hidden == 0) {                        
                        trainingSet.getNetwork().getOutputLayer().getProcessNeurons()[out].getWeightValues()[hidden] += (learningRate
                                * errorOutputLayer[out]);
                    } else {
                        trainingSet.getNetwork().getOutputLayer().getProcessNeurons()[out].getWeightValues()[hidden] += (learningRate
                                * errorOutputLayer[out]
                                * trainingSet.getNetwork().getOutputLayer().getProcessNeurons()[out].getInputValues()[hidden]);
                    }
                }
            }

            
            // Update the weights for the hidden layer.
            for (int hidden = 0; hidden < trainingSet.getNetwork().getHiddenLayer().size(); hidden++) {
                for (int input = 0; input < trainingSet.getNetwork().getInputLayer().size(); input++) {
                    if (input == 0) {
                        trainingSet.getNetwork().getHiddenLayer().getProcessNeurons()[hidden].getWeightValues()[input] += (learningRate
                                * errorHiddenLayer[hidden]);
                    }else{
                        trainingSet.getNetwork().getHiddenLayer().getProcessNeurons()[hidden].getWeightValues()[input] += (learningRate
                                * errorHiddenLayer[hidden]
                                * trainingSet.getNetwork().getHiddenLayer().getProcessNeurons()[hidden].getInputValues()[input]);
                    }
                } 
            }

            double costFunctionValue = trainingSet.calculateCostFunction(0);
            logger.log(Level.INFO, String.format("step: %d cost: %f", i, costFunctionValue));
        }
    }

    private double sigmoidDerivative(final double val) {
        return (val * (1.0 - val));
    }
}
