import java.util.ArrayList;
import java.util.Arrays;

public class FindAreaTest {
    public static void main(String[] args) {
        System.out.println(getPolygonArea(new ArrayList<>(Arrays.asList(0, 0, 2)), new ArrayList<>(Arrays.asList(0, 2, 0))));
        System.out.println(getPolygonArea(new ArrayList<>(Arrays.asList(-1000, -500, 2, 35)), new ArrayList<>(Arrays.asList(500, 1000, 10, 60))));
        System.out.println(getPolygonArea(new ArrayList<>(Arrays.asList(51, 15, 45, 100, 201, 70, 25, 999, 500, 5)), new ArrayList<>(Arrays.asList(-20, 3, 200, -100, 55, -80, 333, 0, 77, -6))));
        System.out.println(getPolygonArea(new ArrayList<>(Arrays.asList(13, 44, -800, 27, 1)), new ArrayList<>(Arrays.asList(-92, 0, 30, 2, 2))));
    }

    /*Для того чтобы найти площадь многоугольника -
    замкнутой ломаной без самопересечений, заданной своими вершинами в порядке обхода,
    для этого нужно найти сумму произведений вершин (xk + xk+1) и (yk - yk+1)
    и данную сумму умножить на 1/2. Где х и y - координаты вершин по осям X и Y соответственно
    k - индекс числа в списке*/
    public static double getPolygonArea(ArrayList<Integer> arrX, ArrayList<Integer> arrY){
        if(arrX.size()!=arrY.size()||arrX.size()<3||arrY.size()<3){//Если передаем меньше 3 вершин, либо передаем 2 разных
            // по размерности списка то кидаем Exception
            throw new ArithmeticException();
        }
        double sum = 0;
        int counter = 0;
        int x1 = arrX.get(0);//Сохраняем координаты начальной вершины
        int y1 = arrY.get(0);
        for (int i = 0; i < arrX.size(); i++) {
            counter++;
            if(counter==arrX.size()){//Если дошли до последней вершины в масиве, то находим произведение сумм вершин по  координате
                // X и разницы вершин  по координате Y последней вершины и начальной вершины
                sum+=(arrX.get(i)+x1)*(arrY.get(i)-y1);
                break;
            }
            sum+=(arrX.get(i)+arrX.get(i+1))*(arrY.get(i)-arrY.get(i+1));
        }
        return Math.abs(0.5*sum);//Получаем модуль площади, так как может быть получен отрицательный ответ
    }
}
