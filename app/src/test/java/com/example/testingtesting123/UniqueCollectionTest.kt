package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    //Test Remove
    @Test
    fun remove() {
        val item1 = Item("item1")
        val item2 = Item("item2")
        val item3 = Item("item3")

        collection.addItem(item1)
        collection.addItem(item2)

        collection.remove(item2)

        assert(collection.size() == 1){"Item not removed"}

        assert(collection.get(0) != item2){"item2 is in the collection"}

        collection.remove(item3)

        assert(collection.size() == 1){"List remains unchanged"}

    }

    //Test Get
    @Test
    fun get() {
        val item1 = Item("item1")
        val item2 = Item("item2")
        val item3 = Item("item3")

        collection.addItem(item1)
        collection.addItem(item2)

        assert(collection.get(0) == item1){"Correct item was fetched"}
    }

}