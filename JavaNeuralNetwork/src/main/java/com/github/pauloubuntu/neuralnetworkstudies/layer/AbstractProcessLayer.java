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

package com.github.pauloubuntu.neuralnetworkstudies.layer;

import java.util.Random;
import com.github.pauloubuntu.neuralnetworkstudies.activation.AbstractActivation;
import com.github.pauloubuntu.neuralnetworkstudies.neuron.ProcessNeuron;

public abstract class AbstractProcessLayer extends AbstractLayer {

    protected AbstractActivation ativacao;
    protected ProcessNeuron[] processNeurons;

    public AbstractProcessLayer(AbstractActivation ativacao) {
        this.ativacao = ativacao;
    }

    public void setInputValues(double[] inputValues) {        
        for (int i = 0; i < processNeurons.length; i++) {
            ProcessNeuron processNeuron = processNeurons[i];
            assert processNeuron != null : "This neuron shouldn't be null. You may have forgotten of generating weights for it, haven't you?";
            processNeuron.setInputValues(inputValues);
        }
    }
    
    public double[] getOutputValues(){
        double[] outputValues = new double[this.processNeurons.length];
        for (int i = 0; i < processNeurons.length; i++) {
            outputValues[i] = processNeurons[i].getOutputValue();            
        }
        return outputValues;
    }

    public void calculate() {
        for (int i = 0; i < processNeurons.length; i++) {
            ProcessNeuron n = processNeurons[i];
            n.setOutputValue(ativacao.perform(n));
        }
    }

    private double[] generateRandomValues(int size) {
        Random random = new Random();
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = Math.random();
        }

        return values;
    }

    public void generateRandomWeights(int length) {
        for (int i = 0; i < processNeurons.length; i++) {
            ProcessNeuron processNeuron = new ProcessNeuron();
            processNeuron.setWeightValues(this.generateRandomValues(length));
            processNeurons[i] = processNeuron;
        }
    }
    
    public int size(){
        return this.processNeurons.length;
    }

    public ProcessNeuron[] getProcessNeurons() {
        return processNeurons;
    }
    
}
