def seleccion( lista):
        for i in range(0, len(lista)):
            menor = lista[i]
            pos = i
            for j in range(i + 1, len(lista)):
                if lista[j] < menor:
                    #Era lista[j], no j
                    menor = lista[j]
                    #falto esto:
                    pos = j
            if pos != i:
                tmp = lista[i]
                lista[i] = lista[pos]
                lista[pos] = tmp
        print("La lista ordenada es: ", lista)

lista=[]
n=int(input("Ingrese el tamaño de la lista: "))
for i in range(n):
    numero=int(input("Ingrese un elemento a la lista: "))
    lista.append(numero)
print(lista)

seleccion(lista)