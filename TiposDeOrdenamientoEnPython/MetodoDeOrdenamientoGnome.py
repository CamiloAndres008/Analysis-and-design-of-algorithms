def gnome(lista):
    i = 1
    while i < len(lista):
        if lista[i]>= lista[i-1]:
            i=i+1
        else:
            temp = lista[i-1]
            lista[i-1]= lista[i]
            lista[i]=temp
            if i>1:
                i=i-1
    print("La lista ordenada es: ", lista)


lista=[]
n=int(input("Ingrese el tamaño de la lista: "))
for i in range(n):
    numero=int(input("Ingrese un elemento a la lista: "))
    lista.append(numero)
print(lista)

gnome(lista)


