package com.arnoer.aop.po;

import com.arnoer.aop.service.CompactDisc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
/** 空白光盘 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist;

    @Override
    public void playTrack(int trackNumber) {

    }
}
