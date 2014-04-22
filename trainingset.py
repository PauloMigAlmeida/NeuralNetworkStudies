__author__ = 'paulomiguelalmeida'

import csv


def read_training_set():
    X = []
    Y = []
    with open('car.data', 'rb') as csvfile:
        carreader = csv.reader(csvfile, delimiter=',', quotechar='|')
        for row in carreader:
            X.append(row[:-1])
            Y.append(row[-1])

    return [normalize_input_nodes(X), normalize_output_nodes(Y)]


def normalize_input_nodes(X):
    for row_idx,row in enumerate(X):
        for cell_idx,cell in enumerate(row):
            X[row_idx][cell_idx] = translate_input_value(cell)
    return X


def normalize_output_nodes(Y):
    for row_idx,row in enumerate(Y):
            Y[row_idx] = translate_output_value(row)
    return Y


def translate_input_value(value):
    if value == 'small' or value == 'low':
        return 1
    elif value == 'med' or value == '2':
        return 2
    elif value == 'big' or value == 'high' or value == '3':
        return 3
    elif value == 'vhigh' or value == '4':
        return 4
    elif value == '5more' or value == 'more':
        return 5


def translate_output_value(value):
    if value == 'unacc':
        return 1
    elif value == 'acc':
        return 2
    elif value == 'good':
        return 3
    elif value == 'vgood':
        return 4