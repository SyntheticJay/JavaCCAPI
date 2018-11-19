# JavaCCAPI

This is a simple library you can use to interact with CCAPI.
Usually, CCAPI is often used in C#, C++ and C, as that's what most people tend to use for `RTM (Real Time Modding)` tools, etc.
But, I thought to myself, why not port it to another language?

Well, thats what I started doing.
Initially, I looked online for some things to help me, and managed to find jCCAPI (https://github.com/Zerotica/jCCAPI-master).
But, after looking at the code, I could do something to make this better, and that's what I `did`.

Now, all types passed in through parameters are enumerated, to make life easier.

e.g.

`CCAPI#notify(String, NotifyIcon)` instead of using regular classes.

and the initial class (`me.jay.CCAPI`) is implemented from an interface called ICCAPI which holds the functions that can be used.
So, if you want an easy way to look at the functions in store, take a look there, it's all commented aswell.

I still have some features to work on, and they are listed here:

- Memory Editing
- Shutdown Command (Not working? ZEROTICA!!)
- Replace ICCAPI with an abstract class, make life _more_ easier.

Right now, it isn't the best, but give me some time :d

Feel free to send a pull request, or an issue, and I'll work on it when I can.

Discord: Jay L.#3668

