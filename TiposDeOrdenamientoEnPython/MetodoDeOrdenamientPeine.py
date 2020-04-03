def peine(lista):
    condicion = True
    tamanio = len(lista)
    while condicion == True or tamanio>1 :
        condicion  = False
        tamanio = math.floor(tamanio/1.3)
        if tamanio < 1 :
            tamanio = 1
        for i in range(0,len(lista)-tamanio):
            if lista[i] > lista[i+tamanio] :
                condicion = True
                aux = lista[i]
                lista[i]= lista[i+tamanio]
                lista[i+tamanio] = aux
    print("La lista ordenada es: ", lista)

lista=[]
n=int(input("Ingrese el tamaño de la lista: "))
for i in range(n):
    numero=int(input("Ingrese un elemento a la lista: "))
    lista.append(numero)
print(lista)

peine(lista)

