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

package com.github.pauloubuntu.neuralnetworkstudies.main;

import com.github.pauloubuntu.neuralnetworkstudies.activation.SigmoidActivation;
import com.github.pauloubuntu.neuralnetworkstudies.nnet.MultiLayerFeedForwardNetwork;
import com.github.pauloubuntu.neuralnetworkstudies.nnet.TranningSet;
import com.github.pauloubuntu.neuralnetworkstudies.tranning.BackPropagationLearningAlgorithm;

import java.util.Arrays;
import java.util.logging.Logger;

public class MultiLayerFeedforwardNetworkTest {

    private static Logger logger = Logger.getGlobal();
    
    public static void main(String[] args) {

        SigmoidActivation sigmoidActivation = new SigmoidActivation();
        MultiLayerFeedForwardNetwork network = new MultiLayerFeedForwardNetwork(2, 4, 1, sigmoidActivation, sigmoidActivation);

        TranningSet tranningSet = new TranningSet(
                new double[][]{
                    {0.0, 0.0},
                    {1.0, 0.0},
                    {0.0, 1.0},
                    {1.0, 1.0}
                },
                new double[][]{
                    {0.0},
                    {1.0},
                    {1.0},
                    {0.0}
                },
                network
        );

        tranningSet.calculateCostFunction(0.0d);

        BackPropagationLearningAlgorithm learningAlgorithm = new BackPropagationLearningAlgorithm(tranningSet);
        learningAlgorithm.train(1.0, 100000);

        // Run it
        predictValue(network, new double[]{0.0, 0.0});
        predictValue(network, new double[]{0.0, 1.0});
        predictValue(network, new double[]{1.0, 0.0});
        predictValue(network, new double[]{1.0, 1.0});

    }

    private static void predictValue(MultiLayerFeedForwardNetwork network, double[] inputValue) {
        logger.info(String.format("Predict: %s output: %s", Arrays.toString(inputValue), Arrays.toString(network.predict(inputValue, false))));
    }

}
