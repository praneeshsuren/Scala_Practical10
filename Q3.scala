class Account(val id: String, private var balance: Double) {

  // Deposit money into the account
  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
    else println("Invalid amount")
  }

  // Withdraw money from the account
  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
    else println("Insufficient balance")
  }

  // Transfer money from this account to another account
  def transfer(amount: Double, to: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      this.withdraw(amount)
      to.deposit(amount)
    }
    else println("Insufficient balance")
  }

  // Get current balance
  def getBalance: Double = balance

  // Overriding toString to display account details
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