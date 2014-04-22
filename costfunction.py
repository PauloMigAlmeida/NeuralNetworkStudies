__author__ = 'paulomiguelalmeida'

import sigmoid_function
import math


def calculate(X, Y, initial_theta1, initial_theta2, input_neurons , hidden_neurons, output_neurons, lambda_value):
    a1 = add_bias_neuron(X)

    #Calculating z2
    z2 = []
    for row_a1_idx, row_a1 in enumerate(a1):
        # print "row_a1_idx: %d" % row_a1_idx
        z2_temp = []
        for i in range(hidden_neurons):
            # print "\thidden_neurons: %d" % i
            sum_a1_values = 0
            for cell_a1_idx, cell_a1 in enumerate(row_a1):
                # print "\t\tcell_a1_idx: %d" % cell_a1_idx
                if cell_a1_idx == 0:
                    sum_a1_values += 1
                else:
                    sum_a1_values += cell_a1 * initial_theta1[i][cell_a1_idx-1]

            z2_temp.append(sigmoid_function.calculate(sum_a1_values))
        z2.append(z2_temp)

    a2 = add_bias_neuron(z2)

    #Calculating z3
    z3 = []
    for row_a2_idx, row_a2 in enumerate(a2):
        # print "row_a2_idx: %d" % row_a2_idx
        z3_temp = []
        for i in range(output_neurons):
            # print "\thidden_neurons: %d" % i
            sum_a2_values = 0
            for cell_a2_idx, cell_a2 in enumerate(row_a2):
                # print "\t\tcell_a2_idx: %d" % cell_a2_idx
                if cell_a2_idx == 0:
                    sum_a2_values += 1
                else:
                    sum_a2_values += cell_a2 * initial_theta2[i][cell_a2_idx-1]

            z3_temp.append(sigmoid_function.calculate(sum_a2_values))
        z3.append(z3_temp)

    a3 = z3
    print len(z3)

    #Calculating Cost Function
    y_eye = identity_matrix(4)
    sum_m_values = 0
    for i in range(len(X)):
        sum_label_values = 0
        for k in range(output_neurons):
            sum_label_values += (-y_eye[Y[i] - 1][k] * math.log10(a3[i][k]) - (1 - y_eye[Y[i] - 1][k]) * math.log10(1 - a3[i][k]))
        sum_m_values += sum_label_values

    #Calculating Regularized Theta
    sum_regularized_theta1_j = 0;
    for row_j_idx, row_j in enumerate(initial_theta1):
        sum_regularized_theta1_k = 0
        for row_k_idx, row_k in enumerate(row_j):
            if row_k_idx != 0:
                sum_regularized_theta1_k += math.pow(row_k,2)
        sum_regularized_theta1_j += sum_regularized_theta1_k

    sum_regularized_theta2_j = 0;
    for row_j_idx, row_j in enumerate(initial_theta2):
        sum_regularized_theta2_k = 0
        for row_k_idx, row_k in enumerate(row_j):
            if row_k_idx != 0:
                sum_regularized_theta2_k += math.pow(row_k,2)
        sum_regularized_theta2_j += sum_regularized_theta2_k

    print sum_regularized_theta1_j, sum_regularized_theta2_j
    return ((float(1)/float(len(X))) * sum_m_values) + ((float(lambda_value)/float((2*len(X)))) * (sum_regularized_theta1_j + sum_regularized_theta2_j))


def add_bias_neuron(matrix):
    new_matrix = []
    for row in matrix:
        new_row = [1]
        for column in row:
            new_row.append(column)
        new_matrix.append(new_row)
    return new_matrix


def identity_matrix(size):
    matrix = [[0]*size for i in range(size)]
    for i in range(size):
        matrix[i][i] = 1
    return matrix
