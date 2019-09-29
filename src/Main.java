import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Eukleiduv alg
        int x = 3000;
        int y = 12600;
        System.out.println(NSD(x, y));
        System.out.println(nsn(x, y));

        //Test prvociselnosti
        System.out.println(jePrv(7917));

        //Prvociselny rozklad
        System.out.println("Rozklady:");
        for(int i : prvRozklad(12600)){
            System.out.print(i + " ");
        }
        System.out.println();

        //Hornerovo schema
        //koeficienty u neznamych polynomu 2*x^3 - 6x^2 + 2x - 1*x^0
        int poly[] = {2, -6, 2, -1};
        int val = 3;
        System.out.println(horner(poly, val));
    }

    //Hledani NSD za pomoci Eukleidova algoritmu
    public static int NSD(int x, int y){
        //Eukleiduv algoritmus
        while(x!=y){
            if(x>y) x=x-y;
            else y=y-x;
        }

        //po ukonceni while cyklu x, y = NSD - nejmensi spolecny delitel
        return x;
    }

    //Hledani nsn za pomoci Eukleidova algoritmu
    public static int nsn(int x, int y){
        int z = x*y/NSD(x,y);

        // podil soucinu puvodnich cisel a jejich NSD je jejich nejmensi spolecny nasobek
        return z;
    }

    //Test, zdali je cislo prvocislo
    public static boolean jePrv(int x){
        //sude
        if (x%2==0) return false;
        //liche
        else {
            int delitel = 3;
            // nema smysl pro cisla vetsi nez odmocnina z hledaneho cisla, jelikoz dve odmocniny jsou nejvetsi dvojice
            // delitelu, pro cisla vetsi uz bychom museli narazit na mensiho delitele pr.: 36 - 2*18, 4*9, 6*6, 9*4, 18*2
            while (delitel < Math.sqrt(x)) {
                if (x % delitel == 0) return false;
                else delitel += 2;
            }
            return true;
        }
    }

    //Rozklad cisla na prvocisla
    public static ArrayList<Integer> prvRozklad(int x){
        //list prvociselnych delitelu x
        ArrayList<Integer> prv = new ArrayList<Integer>();
        int delitel = 2;

        while(x>1){
            if(x%delitel==0) {
                x/=delitel;
                prv.add(delitel);
            } else {
                delitel++;
            }
        }

        return prv;
    }


    //Vycislovani polynomu
    static int horner(int poly[], int x){
        int n = poly.length;
        int result = poly[0];

        // Hornerovo schema
        for (int i=1; i < n; i++) {
            result = result * x + poly[i];
        }
        return result;
    }

}
