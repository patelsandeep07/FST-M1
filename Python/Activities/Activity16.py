class Car:
    'This class represents a car'

    def __init__(self, manufacture,model, make, transmision, color):
        self.manufacture = manufacture
        self.model = model
        self.make = make
        self.transmision = transmision
        self.color = color

    def accelerate(self):
        print(self.manufacture + " " + self.model + " has started moving")

    def stop(self):
        print(self.manufacture + " " + self.model + " has stopped moving")


car1 = Car("Hyundai", "I20", "2016", "Manual","Red")
car2 = Car("Maruti", "Baleno", "2017","Manual" ,"Blue")
car3 = Car("Ford", "Ecosport", "2018","Automatic" ,"Orange")

car1.accelerate()
car1.stop()



