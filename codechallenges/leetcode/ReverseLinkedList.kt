package codechallenges.leetcode

fun main() {
    // [1,2,3,4,5]
    reverseList(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))))
}

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }

    var tail = ListNode(head.`val`)
    var curr = head.next

    while (curr != null) {
        val next = curr.next
        curr.next = tail
        tail = curr
        curr = next
    }

    return tail
}