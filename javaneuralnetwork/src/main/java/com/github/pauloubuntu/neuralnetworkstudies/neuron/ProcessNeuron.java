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

package com.github.pauloubuntu.neuralnetworkstudies.neuron;

import java.util.Arrays;

public class ProcessNeuron {
    private double[] inputValues;
    private double[] weightValues;
    private double outputValue;

    public ProcessNeuron() {
    }

    public ProcessNeuron(double[] inputValues) {
        this.inputValues = inputValues;
    }

    public ProcessNeuron(double[] inputValues, double[] weightValues) {
        this.inputValues = inputValues;
        this.weightValues = weightValues;
    }

    public double[] getInputValues() {
        return inputValues;
    }

    public void setInputValues(double[] inputValues) {
        this.inputValues = inputValues;
    }

    public void setWeightValues(double[] weightValues) {
        this.weightValues = weightValues;
    }

    public double[] getWeightValues() {
        return weightValues;
    }
    
    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }

    @Override
    public String toString() {
        return "\n\t\tProcessNeuron{\n" + "\t\t\tinputValues=" + Arrays.toString(inputValues) + ", \n\t\t\tweightValues=" + Arrays.toString(weightValues) + ", \n\t\t\toutputValue=" + outputValue + "\n\t\t}";
    }
    
    
}
