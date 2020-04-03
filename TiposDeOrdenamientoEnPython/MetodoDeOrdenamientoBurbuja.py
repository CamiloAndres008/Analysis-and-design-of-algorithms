def burbuja(lista):
        for i in range(0, len(lista) - 1):
            for j in range(0, len(lista) - 1):
                if lista[j] > lista[j + 1]:
                    temp = lista[j + 1]
                    lista[j + 1] = lista[j]
                    lista[j] = temp
        print("La lista ordenada es:", lista)


lista=[]
n=int(input("Ingrese el tamaño de la lista: "))
for i in range(n):
	numero=int(input("Ingrese un elemento a la lista: "))
	lista.append(numero)
print(lista)

burbuja(lista)

