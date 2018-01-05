package classes;

public abstract class Decorator extends Parkhaus {
        private Parkhaus parkhaus;

        public Parkhaus getParkhaus() {
                return parkhaus;
        }

        public void setParkhaus(Parkhaus park) {
                parkhaus = park;
        }

        public abstract Parkhaus fromXMLToParkhaus();

        public abstract void toXmlFile();
}
