__author__ = 'paulomiguelalmeida'

import math
import sigmoid_function


def calculate(X, initial_theta1, initial_theta2):
    a1 = add_bias_neuron(X)
    # print a1
    z2 = []
    for i in range(len(initial_theta1)):
        # print "hidden_neurons: %d length:%d" % (i,len(initial_theta1[i]))
        z2_temp = []
        for row_a1_idx, row_a1 in enumerate(a1):
            # print "\trow_a1_idx: %d" % row_a1_idx
            z2_temp.append(initial_theta1[i][row_a1_idx] * a1[row_a1_idx])
        z2.append(sigmoid_function.calculate(sum_vector(z2_temp)))
    # print "z2 ", z2

    z3 = []
    for i in range(len(initial_theta2)):
        # print "output_neurons: %d length:%d" % (i,len(initial_theta1[i]))
        z3_temp = []
        for row_z2_idx, row_z2 in enumerate(z2):
            # print "\trow_z2_idx: %d" % row_z2_idx
            z3_temp.append(initial_theta2[i][row_z2_idx] * z2[row_z2_idx])
        z3.append(sigmoid_function.calculate(sum_vector(z3_temp)))
    # print "z3 ", z3

    return find_maxvalue_vector(z3)

def find_maxvalue_vector(vec):
    biggest_probability_value=-1
    biggest_probability_index=-1
    for value_idx, value in enumerate(vec):
        if value > biggest_probability_value:
            biggest_probability_value = value
            biggest_probability_index = value_idx
    return [biggest_probability_value,biggest_probability_index]

def sum_vector(vec):
    sum_values = 0
    for v in vec:
        sum_values += v
    return sum_values


def add_bias_neuron(matrix):
    new_matrix = []
    new_row = 1
    new_matrix.append(new_row)
    for row in matrix:
        new_matrix.append(row)
    return new_matrix