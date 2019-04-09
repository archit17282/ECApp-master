from math import sqrt
#from operator import itemgetter

#sample data
arr = [(1,2),(5,6),(5,12),(15,12)]    #tuples of coordinates of the route turns
voter_coord  = (8,7)


def nearest_points(array_of_turns, voter_coordinates):
    to_sort = []
    for a,b in zip(array_of_turns[0:], array_of_turns[1:]):
        # (y2-y1 / x2-x1) = y-y1 / x-x1
        # (x-x1)*m = y - y1
        # mx = y - y1 + m*x1
        # y - mx + m*x1 - y1 = 0
        # d = (h - mk + m*x1 - y1)/ sqrt(1 + m*m)
        h,k = voter_coordinates[0],voter_coordinates[1]
        x1,y1,x2,y2 = a[0],a[1],b[0],b[1]
        if (x2-x1) != 0:
            m = (y2-y1)/(x2-x1)
            d = abs(h - m*k + m*x1 - y1)/sqrt(1+m*m)
            if (((k-y1)**2 + (h-x1)**2 - d**2)  <  ((y2-y1)**2 + (x2-x1)**2) )  and ((k-y2)**2 + (h-x2)**2 - d**2  <  (y2-y1)**2 + (x2-x1)**2):
                arrival_coord = (sqrt((((h-x1)**2+(k-y1)**2)/((h-x2)**2 + (k-y2)**2)) ) * (x2-x1) , sqrt((((h-x1)**2+(k-y1)**2)/((h-x2)**2 + (k-y2)**2)) ) * (y2-y1))
            else :
                arrival_coord = (x2,y2) if ((x2-h)**2 + (y2-k)**2) <= ((x1-h)**2 + (y1-k)**2) else (x1,y1)
                d = sqrt(((x2-h)**2 + (y2-k)**2)) if ((x2-h)**2 + (y2-k)**2) <= ((x1-h)**2 + (y1-k)**2) else sqrt(((x1-h)**2 + (y1-k)**2)) 
        if (x2-x1) == 0:
            arrival_coord = (x1,k)
            d = abs(h-x1)
        to_sort.append([d,arrival_coord])
    to_sort = sorted(to_sort,key= lambda x: x[0])
    return to_sort[0]


#print(nearest_points(arr,voter_coord)[0])