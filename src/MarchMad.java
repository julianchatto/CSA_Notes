import java.util.ArrayList;

public class MarchMad {
    public static void main(String[] args) {
        // ArrayList of basketballs!
        ArrayList<Basketball> bin = new ArrayList<>();
        bin.add(new Basketball(8.1));
        bin.add(new Basketball(7.3));
        bin.add(new Basketball(11.0));
        bin.add(new Basketball(7.5));
        bin.add(new Basketball(8.3));

        // Loop through them to check the PSI
        for (int i = 0; i < bin.size(); i++) {
            Basketball b = bin.get(i);
            if (b.getPsi() > 8.5) {
                System.out.println("Ball too hard");
                b.setPsi(8.5);
            } else if (b.getPsi() < 7.5) {
                System.out.println("Ball to soft");
                b.setPsi(7.5);
            } else {
                System.out.println("Quality ball");
            }
        }

        System.out.println("Ball PSIs Ready For the Game");
        for (Basketball b : bin) {
            System.out.println(b.toString());
        }
    }
}

class Basketball {
    private double psi;

    Basketball(double p) {
        this.psi = p;
    }

    public double getPsi() {
        return psi;
    }

    public void setPsi(double psi) {
        this.psi = psi;
    }

    @Override
    public String toString() {
        return "Basketball{" +
                "psi=" + psi +
                '}';
    }
}