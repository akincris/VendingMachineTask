# Vending Machine Software

  This is a Java based software designed to run on a Vending machine. The moment
a consumer enters a selection using buttons,it will report the selected product Id,name and price.
The machine will prompt the user to pay in US dollars and return the change after payment.


  Knowing that the customer should interact with the machine, enter and receive messages from it, I designed a simple user interface using JavaFx.
Almost all the methods are called from the Controller class using buttons and labels.The Controller class which implements the VendingMachineInterface has methods for displaying the product menu, select a product and calculate the balance and it's change. The calculations
will be made using an Calculator object and BillEnter class which is helping calculating the entered balance.We also have Bills enum for representing the US dollars and their values.The passed string of entered bills is converted to a double array and passed for calculations. The Product class though creates objects for our vending machine with their uniq name,ID,amount and price. I've also used labelsArrayList and productsArrayList for storing labels and products from the menu.


## Instructions

  1.First of all click the "*START*" button above to display the product menu.

  2.Enter the product Id using the radio buttons on the left and click "*OK*". In case the machine is short of the desired product a message will appear, announcing the customer. If not the machine will report the product Id,name and price.

  3.The machine accepts only $1,$5,$10,$20,$50,$100 bills. To enter your money enter a string of six integers, which represents the number of the bills, leaving blank space between each one.
  Example: 3 0 0 0 0 2  BALANCE:$203.0        Example:1 0 2 2 0 0 BALANCE:$61.0

  If the balance is not enough for payment, again the machine will display a message announcing the customer.

  4.After introducing the bills, a message will report the total entered balance. Click "*PAY*" to perform the payment.The change will be reported right afterwards.

  5.If there's an update ready for this machine, click "*Loading New Options*" below .



