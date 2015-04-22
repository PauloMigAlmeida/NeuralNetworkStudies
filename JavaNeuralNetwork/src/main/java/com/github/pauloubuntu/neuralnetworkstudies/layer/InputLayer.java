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

import java.util.Arrays;
import com.github.pauloubuntu.neuralnetworkstudies.neuron.InputNeuron;

public class InputLayer extends AbstractLayer {

    private InputNeuron[] inputNeurons;

    public InputLayer(int size) {
        this.inputNeurons = new InputNeuron[size];
    }

    public InputNeuron[] getInputNeurons() {
        return inputNeurons;
    }

    public void setInputNeurons(InputNeuron[] inputNeurons) {
        this.inputNeurons = inputNeurons;
    }

    public void setInputValues(double[] inputValues){
        this.inputNeurons = new InputNeuron[inputValues.length];
        for (int i = 0; i < inputValues.length; i++) {
            this.inputNeurons[i] = new InputNeuron(inputValues[i]);            
        }
    }
    
    public double[] getInputValues(){
        double[] inputValues = new double[this.inputNeurons.length];
        for (int i = 0; i < inputNeurons.length; i++) {
            inputValues[i] = inputNeurons[i].getInputValue();            
        }
        return inputValues;
    }
    
    @Override
    public void addBiasNeuron() {
        InputNeuron[] neuronsTemp = new InputNeuron[this.inputNeurons.length + 1];
        neuronsTemp[0] = new InputNeuron(1.0);
        System.arraycopy(inputNeurons, 0, neuronsTemp, 1, inputNeurons.length);
        this.inputNeurons = neuronsTemp;
    }
    
    public int size(){
        return this.inputNeurons.length;
    }

    @Override
    public String toString() {
        return "InputLayer{\n\t" + "inputNeurons=" + Arrays.toString(inputNeurons) + "\n}";
    }

    
        
}
