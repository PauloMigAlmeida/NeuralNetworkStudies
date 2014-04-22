__author__ = 'paulomiguelalmeida'


inputLayer = 5
hiddenLayer = 6
outputLayer = 4

xises = ''
for i in range(1, inputLayer+1):
    xises += "x%d " % i

print xises[:-1]


ases = ''
for i in range(1, hiddenLayer+1):
    ases += "a%d2 " % i

print ases[:-1]


connections=''

for i in range(1,inputLayer+1):
    for j in range(1,hiddenLayer+1):
        connections += ("\tx%d -> a%d2;\n") % (i,j)

print connections


outputs = ''
for i in range(1, hiddenLayer+1):
    for j in range(1,outputLayer+1):
        outputs += ("\ta%d2 -> O%d\n") % (i,j)

print outputs[:-1]