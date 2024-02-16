package codechallenges.leetcode

/**
 * LeetCode 2: Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */

data class ListNode(var `val`: Int = 0, var next: ListNode? = null) {
    override fun toString(): String {
        return "$`val` -> $next"
    }
}

fun main() {
    val l1 = ListNode(2, ListNode(4, ListNode(3)))
    val l2 = ListNode(5, ListNode(6, ListNode(4)))

    val result = addTwoNumbers(l1, l2)
    println(result)
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var carry = 0

    var next1 = l1
    var next2 = l2

    val dummy = ListNode()
    var curr = dummy

    while (next1 != null || next2 != null || carry > 0) {
        val next1val = next1?.`val` ?: 0
        val next2val = next2?.`val` ?: 0

        var addition = next1val + next2val + carry
        carry = addition / 10
        addition %= 10
        curr.next = ListNode(addition)

        curr = curr.next!!
        next1 = next1?.next
        next2 = next2?.next
    }

    return dummy.next
}