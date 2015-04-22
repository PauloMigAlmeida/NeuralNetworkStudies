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

package com.github.pauloubuntu.neuralnetworkstudies.nnet;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.github.pauloubuntu.neuralnetworkstudies.activation.AbstractActivation;
import com.github.pauloubuntu.neuralnetworkstudies.layer.HiddenLayer;
import com.github.pauloubuntu.neuralnetworkstudies.layer.InputLayer;
import com.github.pauloubuntu.neuralnetworkstudies.layer.OutputLayer;

public class MultiLayerFeedForwardNetwork {

    private Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private InputLayer inputLayer;
    private HiddenLayer hiddenLayer;
    private OutputLayer outputLayer;

    public MultiLayerFeedForwardNetwork(int inputLayerSize, int hiddenLayerSize, int outputLayerSize, AbstractActivation hiddenLayerActivation, AbstractActivation outputLayerActivation) {
        this.inputLayer = new InputLayer(inputLayerSize);
        this.hiddenLayer = new HiddenLayer(hiddenLayerSize, hiddenLayerActivation);
        this.outputLayer = new OutputLayer(outputLayerSize, outputLayerActivation);
        
        this.hiddenLayer.generateRandomWeights(inputLayerSize + 1);
        this.outputLayer.generateRandomWeights(hiddenLayerSize + 1);
    }

    public InputLayer getInputLayer() {
        return inputLayer;
    }

    public HiddenLayer getHiddenLayer() {
        return hiddenLayer;
    }

    public OutputLayer getOutputLayer() {
        return outputLayer;
    }
    
    public double[] predict(double[] inputValues, boolean debug){        
        this.inputLayer.setInputValues(inputValues);
        this.inputLayer.addBiasNeuron();
        log(debug,this.inputLayer.toString());   
        
        this.hiddenLayer.setInputValues(this.inputLayer.getInputValues());
        this.hiddenLayer.calculate();
        log(debug,this.hiddenLayer.toString());
        
        this.hiddenLayer.addBiasNeuron();
        this.outputLayer.setInputValues(this.hiddenLayer.getOutputValues());
        this.hiddenLayer.removeBiasNeuron();
        this.outputLayer.calculate();        
        log(debug,this.outputLayer.toString());
        
        return this.outputLayer.getOutputValues();
    }
    
    private void log(boolean debug, String message){
        if(debug){
            logger.log(Level.INFO,message);   
        }
    }

}
