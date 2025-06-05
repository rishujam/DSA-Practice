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

fun main() {
    val x = "wordgoodgoodgoodbestword"
//    print(x.replaceFirst("word", ))
}