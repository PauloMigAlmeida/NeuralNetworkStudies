__author__ = 'paulomiguelalmeida'

import trainingset
import costfunction
import random


input_neurons = 6
hidden_neurons = 7
output_neurons = 4

[X, Y] = trainingset.read_training_set()

initial_theta1 = [[random.random() for e in range(input_neurons)] for e in range(hidden_neurons)];
initial_theta2 = [[random.random() for e in range(hidden_neurons)] for e in range(output_neurons)];

print initial_theta1
print initial_theta2
print Y

j = costfunction.calculate(X, Y, initial_theta1, initial_theta2, input_neurons, hidden_neurons, output_neurons,1)
print j