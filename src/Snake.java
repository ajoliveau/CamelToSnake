public class Snake {
    public static void main(String[] args) {
        int lasttype = 0; // Type du dernier caractère : 2 = majuscule, 1 = minuscule, 0 = autre
        char nextcar = Pep8.chari();
        char car;
        while(nextcar != '\n' ) {
            car = nextcar;
            nextcar = Pep8.chari();
            if (car>96 && car <123) {  // Si le caractère est une lettre minuscule
                lasttype = 1;
                Pep8.charo(car);
            } else if (car>64 && car<91) { // Si le caractère est une lettre majuscule
                if (lasttype == 1)
                    Pep8.charo('_');
                else if (lasttype == 2 && nextcar > 96 && nextcar < 123) {
                    Pep8.charo('_');
                }
                Pep8.charo((char) (car+32));
                lasttype = 2;
            }
            else {
                Pep8.charo(car);
                lasttype = 0;
            }
        }
        Pep8.charo((char) 10);
        Pep8.stop();
    }

}




