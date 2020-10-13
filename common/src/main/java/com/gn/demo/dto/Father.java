package com.gn.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Father {
    /**
     * 长相
     */
    private String face;

    /**
     * 身高
     */
    private String height;

    /**
     * 生命
     */
    private Life life;

}