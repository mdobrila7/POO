package ex1;

interface Engine {
    int getFuelCapacity();
}

class Car {
//    static class OttoEngine implements Engine {
//        private int fuelCapacity;
//
//        public OttoEngine(int fuelCapacity) {
//            this.fuelCapacity = fuelCapacity;
//        }
//
//        public int getFuelCapacity() {
//            return fuelCapacity;
//        }
//    }
//
//    public OttoEngine getEngine() {
//        OttoEngine engine = new OttoEngine(11);
//        return engine;
//    }

//    public Engine getEngine(int fuelCapacity) {
//        return new Engine () {
//            private int fuelCapacity = 11;
//
//            public int getFuelCapacity() {
//                return fuelCapacity;
//            }
//        };
//    }

//    public Engine getEngine() {
//        class OttoEngine implements Engine {
//            private int fuelCapacity = 11;
//
//            public int getFuelCapacity() {
//                return fuelCapacity;
//            }
//        }
//
//        return new OttoEngine();

//    public Engine getEngine(int fuelCapacity) {
//        if (fuelCapacity == 11) {
//            class OttoEngine implements Engine {
//                private int fuelCapacity = 11;
//
//                public int getFuelCapacity() {
//                    return fuelCapacity;
//                }
//            }
//
//            return new OttoEngine();
//        }
//
//        return null;
//    }

    class Engine {
        public void getFuelCapacity() {
            System.out.println("I am a generic Engine");
        }
    }
}
class OttoEngine extends Car.Engine {
    // EROARE, avem nevoie de o legatura la obiectul clasei exterioare

    OttoEngine(Car car) { // OK
        car.super();
    }
}

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        // System.out.println(car.getEngine().getFuelCapacity());

        // Car.OttoEngine firstEngine = car.getEngine();
        //Car.OttoEngine secondEngine = car.new OttoEngine(10);

        //System.out.println(car.getEngine(10).getFuelCapacity());
        // System.out.println(car.getEngine(11).getFuelCapacity());
        //System.out.println(firstEngine.getFuelCapacity());
        //System.out.println(secondEngine.getFuelCapacity());

        OttoEngine ottoEngine = new OttoEngine(car);
        ottoEngine.getFuelCapacity();
    }
}