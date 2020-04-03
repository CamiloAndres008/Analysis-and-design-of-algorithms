def burbujaBidireccional(lista):
        izquierdo = 0
        derecho=len(lista)-1
        ultimo=derecho
        condicion=False
        while condicion==False:
            if izquierdo < derecho:
                for i in range(izquierdo, derecho):
                    if lista[i]>lista[i+1]:
                        aux = lista[i]
                        lista[i]=lista[i+1]
                        lista[i+1]=aux
                        ultimo=i
                derecho=ultimo
                for j in range(derecho, izquierdo, -1):
                    if lista[j-1]>lista[j]:
                        aux = lista[j]
                        lista[j]=lista[j-1]
                        lista[j-1]=aux
                        ultimo=j
                        izquierdo=ultimo
            else:
                  condicion = True
        print("La lista ordenada es:", lista)




lista=[]
n=int(input("Ingrese el tamaño de la lista: "))
for i in range(n):
	numero=int(input("Ingrese un elemento a la lista: "))
	lista.append(numero)
print(lista)


burbujaBidireccional(lista)

