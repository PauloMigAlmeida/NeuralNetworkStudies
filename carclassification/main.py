__author__ = 'paulomiguelalmeida'

import trainingset
import costfunction
import predict
import random


input_neurons = 6
hidden_neurons = 7
output_neurons = 4

[X, Y] = trainingset.read_training_set()

initial_theta1 = [[random.random() for e in range(input_neurons+1)] for e in range(hidden_neurons)];
initial_theta2 = [[random.random() for e in range(hidden_neurons+1)] for e in range(output_neurons)];

print 'initial_theta1', initial_theta1
print 'initial_theta2', initial_theta2

j = costfunction.calculate(X, Y, initial_theta1, initial_theta2, input_neurons, hidden_neurons, output_neurons, 1)
print 'initial_costfunction', j

print 'calculating accuracy for training set'
successful_predictions=0
for data_idx,data_value in enumerate(X):
    [value,idx] = predict.calculate(X[data_idx],initial_theta1,initial_theta2)
    print 'predicted value for', X[1], 'is',idx+1
    if idx+1 == Y[data_idx]:
        successful_predictions+=1

print 'calculated accuracy is', ((100*successful_predictions)/len(X)),'%'