while True:
    a = int(input("A:"))
    b = int(input("B:"))
    c = int(input("C:"))

    if (a+b <= c) or (a+c <=b) or (b+c <=a):
        print("error")
    elif (a*a+b*b == c*c) or (a*a+c*c == b*b) or (c*c+b*b == a*a):
        print("jig gas")
    elif (a*a+b*b < c*c ) or (a*a+c*c < b*b) or (c*c+b*b < a*a):
        print("doongak")
    else:
        print("Yegak")
