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
}