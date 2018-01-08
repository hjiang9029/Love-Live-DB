# Love Live! DB
<p> A parser for Love Live! School Idol Project. This uses a .json that I've created myself off of the data pulled from the Love Live Wikia. </p>
</br>
<p> Nearly all of the µ's songs have centers, so songs will be grouped up with their respective center. Any solos, duets and trios are included in the
    "misc" section in the .json. </p>
</br>
<p> The Aqours group is different in that many of their songs do not have a center, therefore a temporary "dummy" object is created to store songs. In the       same object, the sub unit songs will also be stored. However, if a song does have an official center, they will be stored the same way as the µ's songs.     Also in the same vein, any solos, duets or trios are stored in an idol's misc section. </p>
</br>
<p> Also the songs are entered in the .json are entered based on chronological order. When editing the .json, the implementation of the parser will take that into account and use that as part of its implementation. </p>

<p> DISCLAIMER: Data retrieved from Love Live Wikia: http://love-live.wikia.com/wiki/Main_Page
    I have only retrieved the data from the site and formatted the data in this file. </p>