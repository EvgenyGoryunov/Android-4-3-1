public class Tank {

    int direction;      // текущее направление танка 0-вправо, 1-вниз, 2-влево, 3-вверх
    int x;              // позиция по оси x
    int y;              // позиция по оси y
    int fuel = 100;     // топливо (дефолтное значение = 100)

    // конструктор класса №1
    public Tank() {
    }

    // конструктор класс №2
    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // конструктор класса №3
    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
    }

    // поворота танка вправо
    void turnRight() {
        direction += 1;
        if (direction == 4) direction = 0;
    }

    // поворота танка влево
    void turnLeft() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    // движения танка вперед
    void goForward(int newPosition) {
        if (fuel > newPosition) {
            fuel = fuel - newPosition;
            if (direction == 0) x += newPosition;
            else if (direction == 1) y += newPosition;
            else if (direction == 2) x -= newPosition;
            else if (direction == 3) y -= newPosition;
        } else if (fuel <= newPosition) {
            newPosition = fuel;
            if (direction == 0) x += newPosition;
            else if (direction == 1) y += newPosition;
            else if (direction == 2) x -= newPosition;
            else if (direction == 3) y -= newPosition;
            fuel = 0;
        }

    }

    // движения танка назад
    void goBackward(int newPosition) {
//        goForward(-newPosition);
        if (fuel > newPosition) {
            fuel = fuel - newPosition;
            if (direction == 0) x -= newPosition;
            else if (direction == 1) y -= newPosition;
            else if (direction == 2) x += newPosition;
            else if (direction == 3) y += newPosition;
        } else if (fuel <= newPosition) {
            newPosition = fuel;
            if (direction == 0) x -= newPosition;
            else if (direction == 1) y -= newPosition;
            else if (direction == 2) x += newPosition;
            else if (direction == 3) y += newPosition;
            fuel = 0;
        }
    }

    // выведение в консоль текущего положения танка
    void printPosition() {
        System.out.println("The Tank is at " + x + ", " + y + " now.");
    }

}

/*
    test(TestTank)
org.junit.ComparisonFailure:

expected:
The Tank is at -[100, 0 now.
The Tank is at   120, -10 now.
The Tank is at   170], 30 now.

but was:
The Tank is at -[200, 0 now.
The Tank is at   120, -10 now.
The Tank is at - 31], 30 now.
*/

/*
Вывод в консоль при простом блоке goBackward
The Tank is at 100, 0 now.
The Tank is at 110, 10 now.
The Tank is at 220, 30 now.
*/

/*
Вывод в консоль при сложном блоке goBackward, путь у второго танка полож = 200
The Tank is at 100, 0 now.
The Tank is at -90, 10 now.
The Tank is at 220, 30 now.
*/