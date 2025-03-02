package org.ledger;

import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.ledger.services.LedgerService;

public class MainAppBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(LedgerService.class).to(LedgerService.class).in(Singleton.class);
    }
}
