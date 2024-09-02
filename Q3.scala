class Account(val id: String, private var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
    else println("Invalid amount")
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
    else println("Insufficient balance")
  }

  def transfer(amount: Double, to: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      to.deposit(amount)
    }
    else println("Insufficient balance")
  }

  def getBalance: Double = balance

  override def toString: String = s"Account(id: $id, balance: $balance)"
}

@main def main1(): Unit = {
  val acc1 = new Account("123", 1000)
  val acc2 = new Account("124", 2000)
  println("Initial account details:")  
  println(acc1)
  println(acc2)

  acc1.deposit(500)
  acc2.withdraw(1000)

  println("\nAccount details after deposit and withdrawal:")
  println(acc1)
  println(acc2)

  acc1.transfer(200, acc2)

  println("\nAccount details after transfer:")
  println(acc1)
  println(acc2)
}