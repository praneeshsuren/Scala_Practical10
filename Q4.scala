class Account(val id: String, private var balance: Double) {

  def deposit(amount: Double): Unit = {
    if (amount > 0) balance += amount
    else println("Invalid amount")
  }

  def withdraw(amount: Double): Unit = {
    balance -= amount
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

class Bank(val accounts: List[Account]) {

  def accountsWithNegativeBalances: List[Account] = accounts.filter(_.getBalance < 0)

  def totalBalance: Double = accounts.map(_.getBalance).sum

  def applyInterest(): Unit = {
    accounts.foreach { account =>
      if (account.getBalance > 0) {
        account.deposit(account.getBalance * 0.05)
      } else {
        account.withdraw(account.getBalance.abs * 0.1)
      }
    }
  }
}


@main def main2(): Unit = {  

    val acc1 = new Account("001", 1000.0)
    val acc2 = new Account("002", -500.0)
    val acc3 = new Account("003", 200.0)

    val bank = new Bank(List(acc1, acc2, acc3))

    println("Initial account details:")
    bank.accounts.foreach(println)

    println("\nAccounts with negative balances:")
    bank.accountsWithNegativeBalances.foreach(println)

    println(s"\nTotal balance: ${bank.totalBalance}")

    bank.applyInterest()
    println("\nBalances after applying interest:")
    bank.accounts.foreach(println)

}