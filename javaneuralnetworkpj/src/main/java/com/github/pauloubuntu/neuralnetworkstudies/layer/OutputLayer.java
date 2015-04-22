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
import com.github.pauloubuntu.neuralnetworkstudies.activation.AbstractActivation;
import com.github.pauloubuntu.neuralnetworkstudies.neuron.ProcessNeuron;

public class OutputLayer extends AbstractProcessLayer {

    public OutputLayer(int size, AbstractActivation ativacao) {
        super(ativacao);
        this.processNeurons = new ProcessNeuron[size];
    }
    
    public OutputLayer(ProcessNeuron[] processNeurons, AbstractActivation ativacao) {
        super(ativacao);
        this.processNeurons = processNeurons;
    }
    
    @Override
    public void addBiasNeuron() {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public String toString() {
        return "OutputLayer{\n\t" + "processNeurons=" + Arrays.toString(processNeurons) + "\n}";
    }
}
