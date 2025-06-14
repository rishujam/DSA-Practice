package linkedlist.util

object DataGen {

    fun getLinkedList(values: List<Int>): ListNode {
        return ListNode(1)
    }

    fun getCycleLinkedList(
        values: List<Int>,
        cycleStartInd: Int,
        cycleEndInd: Int
    ): ListNode {
        val head = ListNode(values[0])
        var tempHead = head
        var cycleStartNode: ListNode? = null
        for(i in values.indices) {
            val newNode = ListNode(values[i])
            if(i == cycleStartInd) {
                cycleStartNode = newNode
            }
            if(i == 0) {
                continue
            }
            tempHead.next = newNode
            tempHead = tempHead.next!!
            if(i == cycleEndInd) {
                tempHead.next = cycleStartNode
            }
        }
        return head
    }

    fun testCycleGen(input: ListNode) {
        var head = input
        while (head.next != null ) {
            println(head.`val`.toString() + "->")
            head = head.next!!
        }
    }

    @JvmStatic
    fun printLinkedList(node: ListNode) {
        var temp = node
        while(temp != null) {
            print(temp.`val`.toString() + "->")
            temp = temp.next
        }
    }

    @JvmStatic
    fun getSize5LinkedList(): ListNode {
        val input = ListNode(1);
        input.next = ListNode(2);
        input.next.next = ListNode(3);
        input.next.next.next = ListNode(4);
        input.next.next.next.next = ListNode(5);
        return input
    }

    @JvmStatic
    fun getSize2LinkedList(): ListNode {
        val input = ListNode(1)
        input.next = ListNode(2)
        return input
    }
}

fun logDumpGetUniques(): String {
    val log_dump = "name=John Trust, username=john3, email=john3@gmail.com, id=434453; name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; name=Robert M, username=rm44, id=222342, email=rm@me.com; name=Robert M, username=rm4411, id=5535, email=rm@me.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"

    val seenUsernames = mutableSetOf<String>()
    val uniqueLogs = mutableListOf<String>()

    val logItems = log_dump.split(";")

    for (item in logItems) {
        if (item.isBlank()) continue

        val properties = item.split(",")
            .map { it.trim() }
            .filterNot { it.startsWith("id=") || it.startsWith("id =") }

        val usernameEntry = properties.find { it.startsWith("username=") }
        val username = usernameEntry?.substringAfter("=")?.trim()

        if (username != null && seenUsernames.add(username)) {
            val formatted = properties.joinToString(", ") { it.replace("=", ":") }
            uniqueLogs.add(formatted)
        }
    }

    return uniqueLogs.joinToString("; ")
}

fun logDumpGetUniques2(): String {
    val log_dump = "name=John Trust, username=john3, email=john3@gmail.com, id=434453; name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; name=Robert M, username=rm44, id=222342, email=rm@me.com; name=Robert M, username=rm4411, id=5535, email=rm@me.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"

    val seenUsernames = mutableSetOf<String>()
    val uniqueLogs = mutableListOf<String>()

    val logItems = log_dump.split(";")

    for (item in logItems) {
        if (item.isBlank()) continue

        val properties = item.split(",")
            .map { it.trim() }
            .filterNot { it.startsWith("id=") || it.startsWith("id =") }

        val usernameEntry = properties.find { it.startsWith("username=") }
        val username = usernameEntry?.substringAfter("=")?.trim()

        if (username != null && seenUsernames.add(username)) {
            val formatted = properties.joinToString(", ") { it.replace("=", ":") }
            uniqueLogs.add(formatted)
        }
    }

    return uniqueLogs.joinToString("; ")
}


fun main() {
    System.out.println(logDumpGetUniques2().split(";"))
}