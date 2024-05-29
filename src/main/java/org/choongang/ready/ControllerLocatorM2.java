package org.choongang.ready;

import org.choongang.global.Controller;
import org.choongang.ready.contents.ReadyMenu;

public interface ControllerLocatorM2 {
    Controller find(ReadyMenu readyMenu);
}
