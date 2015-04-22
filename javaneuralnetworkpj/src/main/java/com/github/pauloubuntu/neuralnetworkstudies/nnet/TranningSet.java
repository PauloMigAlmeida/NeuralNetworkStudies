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

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TranningSet {
    private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    private double[][] x;
    private double[][] y;
    private MultiLayerFeedForwardNetwork network;

    public TranningSet(double[][] x, double[][] y, MultiLayerFeedForwardNetwork network) {
        this.x = x;
        this.y = y;
        this.network = network;
    }

    public double calculateCostFunction(double lambda){
        assert x.length > 0 : "THe length of x values must be greater than 0";
        assert y.length > 0 : "THe length of y values must be greater than 0";
        assert x.length == y.length : "The length of x values must be equals to y values";
        
        logger.log(Level.FINE, "x features: {0}", Arrays.deepToString(x));
        logger.log(Level.FINE, "y values: {0}", Arrays.deepToString(y));
        
        double costFunctionValue;
        double sumValues = 0.0d;
        for (int i = 0; i < x.length; i++) { // each sample data
            for (int k = 0; k < y[i].length; k++) { // each possible output neuron
                sumValues += y[i][k] * Math.log(network.predict(x[i], false)[k]) + (((double)1) - y[i][k]) * Math.log((((double)1) - network.predict(x[i], false)[k]));
            }
        }
        
        costFunctionValue = -((double)1)/((double)x.length) * sumValues;
        
        // TODO: Implement regularization value : https://youtu.be/keQ1kNIU96Y?t=6m37s
        
        logger.log(Level.FINE, "cost function: {0}", costFunctionValue);
        return costFunctionValue;
    }

    public double[][] getX() {
        return x;
    }

    public double[][] getY() {
        return y;
    }

    public MultiLayerFeedForwardNetwork getNetwork() {
        return network;
    }
    
}
