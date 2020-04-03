def insercion(lista):
    i=1
    for i in range(i,len(lista)) :
        aux = lista[i]
        j = i - 1
        while j>= 0 and aux < lista[j] :
            lista[j+1] = lista[j]
            j=j-1
        lista[j+1]=aux

    print("La lista ordenada es: ", lista)


lista=[]
n=int(input("Ingrese el tamaño de la lista: "))
for i in range(n):
    numero=int(input("Ingrese un elemento a la lista: "))
    lista.append(numero)
print(lista)

insercion(lista)