def is_primo_relativo(n, x):
    return not bool(set(divisores(n)).intersection(divisores(x)))

def anteriores(n):
    return list(range(n, 1, -1))

def divisores(n):
    return [x for x in anteriores(n) if n%x == 0]

qtd = int(input(""))
for i in range(qtd):
    num = int(input(""))
    output = [x for x in anteriores(num) if is_primo_relativo(num, x)]
    print(len(output) + 1)