package  com.path.actions.common.dynamicscreen;

/**
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Nazim Jassar
 *
 */

public interface GenericGridOperation<INPUT, OUTPUT>
{
    public void input(INPUT input);

    public OUTPUT result();

    public void process();
}
