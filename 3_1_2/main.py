# Check out de remédios permitidos para o usuário

def checkOut(Remedios):
    listaProibidos = remediosProibidos()  # Retorna a lista com os remédios proibidos
    negados = []
    tam = len(listaProibidos) - 1

    if listaProibidos != 0:
        for i in Remedios:
            veri = buscaRemedio(listaProibidos, 0, tam, i.upper())

            if veri == 1:
                negados.append(i)

    return negados


def remediosProibidos():
    with open('remediosUsuario.txt', encoding="utf8") as arqUsuario:
        listaRemedios = arqUsuario.readlines()

        for i in range(len(listaRemedios)):
            listaRemedios[i] = listaRemedios[i].rstrip("\n")

    return listaRemedios


def buscaRemedio(proibidos,i, j, buscado):
    meio = (i + j)//2

    if i > j:
        return 0

    if proibidos[meio].upper() == buscado:
        return 1
    elif proibidos[meio].upper() < buscado:
        return buscaRemedio(proibidos, meio + 1, j, buscado.upper())
    else:
        return buscaRemedio(proibidos, i, meio - 1, buscado.upper())


print(checkOut(["ADINOS"]))
