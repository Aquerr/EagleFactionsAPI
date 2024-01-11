package io.github.aquerr.eaglefactions.api.entities;

public interface AcceptableInvite<T extends Inviter, O extends InviteAcceptor>
{
    void accept();

    T getSender();

    O getInvited();
}
