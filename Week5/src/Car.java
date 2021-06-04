import java.util.ArrayList;

public class Car {
	Body body;
	Chassis chassis;
	ArrayList<Wheel> wheels;
	Engine engine;
	
	public Car() {
		this.body = new Body();
		this.chassis = new Chassis();
		this.engine = new Engine();
		this.wheels = new ArrayList<Wheel>();
		for (int i=0; i<4 ;i++) {
			Wheel wh = new Wheel();
			wheels.add(wh);
		}
	}
	
	public void print() {
		System.out.println("Car parts:\n" + 
				"	Body\n" + 
				"	Chassis\n" + 
				"	Engine\n" + 
				"	4 Wheel");
	}
	
}

class Body {
	public Body() {
		System.out.println("Manufacturing: Body");
	}
}
class Chassis {
	public Chassis() {
		System.out.println("Manufacturing: Chassis");
	}
}
class Wheel {
	public Wheel() {
		System.out.println("Manufacturing: Wheel");
	}
}
class Engine {
	public Engine() {
		System.out.println("Manufacturing: Engine");
	}
}


/*
 * https://vw4.viope.com/student/11266/#/prog/97602/67268
 
En: Create 5.1. diagram as a Java program. 
Classes do not have to have any methods and they don't have to do anything more than print text 
(excluding constructor). 

Create each part that belongs to the car as a class part (defined in the same file as Car class) 
and add them to the car when a car is being created. Add a method print() to the Car 
that can tell what parts the car has. Also in each constructor, 
print out which part is being created. 

Example output:
Manufacturing: Body
Manufacturing: Chassis
Manufacturing: Engine
Manufacturing: Wheel
Manufacturing: Wheel
Manufacturing: Wheel
Manufacturing: Wheel
Car parts:
	Body
	Chassis
	Engine
	4 Wheel
*/