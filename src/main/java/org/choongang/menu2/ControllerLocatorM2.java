package org.choongang.menu2;

import org.choongang.global.Controller;
import org.choongang.menu2.contents.Menu2;

public interface ControllerLocatorM2 {
    Controller find(Menu2 menu2);
}
