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

package com.github.pauloubuntu.neuralnetworkstudies.activation;

import com.github.pauloubuntu.neuralnetworkstudies.neuron.ProcessNeuron;

public class SigmoidActivation extends AbstractActivation {

    private double alpha;

    public SigmoidActivation() {
        this.alpha = 1.0;
    }
    
    public SigmoidActivation(double alpha) {
        this.alpha = alpha;
    }    

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
    
    
    @Override
    public double perform(ProcessNeuron processNeuron) {
        double x = this.sum(this.multiply(processNeuron.getInputValues(), processNeuron.getWeightValues()));
        return (1 / (1 + Math.pow(Math.E, (-alpha * x))));
        
    }
}
