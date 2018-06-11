# MyDataStructure
The task is to implement MyDataStructure with the following charectaristics.

  1. max items is given in the constructor (int capacity). when adding new keys - make sure capacity is not breached by removing oldest inserted items if necessary
  2. every item should be removed after the time-to-live has elapsed (unless time-to-live is 0 and then the item does not expire)
  3. get, put, remove, size should all have a complexity of o(1) in average
  4. you may use internally any java data structures, and any number of threads


**exercise success criteria is that "mvn install" succeeds**

